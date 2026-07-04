package com.potatolabs.tinderapro.data.repository

import android.app.Activity
import android.content.Context
import android.util.Log

import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.potatolabs.tinderapro.R
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImpl @Inject constructor(
    private val context: Context,
    private val credentialManager: CredentialManager,
    private val auth: FirebaseAuth,
): AuthRepository {
    override suspend fun signInWithGoogle(
        activity : Activity
    ): Result<String> {
        return try {

            val webClientId = context.getString(R.string.default_web_client_id)
            Log.d(TAG,webClientId)
            val googleIdOption = GetGoogleIdOption.Builder()
                .setServerClientId(webClientId)
                .setFilterByAuthorizedAccounts(false)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val credentialResponse = credentialManager.getCredential(
                context = activity,
                request = request
            )

            val credential = credentialResponse.credential

            if (
                credential is CustomCredential &&
                credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
            ) {

                val googleCredential =
                    GoogleIdTokenCredential.createFrom(credential.data)

                val firebaseCredential = GoogleAuthProvider.getCredential(
                    googleCredential.idToken,
                    null
                )

                val result = auth
                    .signInWithCredential(firebaseCredential)
                    .await()

                val uid = result.user?.uid
                    ?: return Result.failure(
                        IllegalStateException("User is null.")
                    )

                Result.success(uid)

            } else {

                Result.failure(
                    IllegalStateException("Invalid Google credential.")
                )

            }

        } catch (e: GetCredentialCancellationException) {

            Result.failure(e)

        } catch (e: GetCredentialException) {

            Log.e(TAG, "Credential Manager Error", e)
            Result.failure(e)
        } catch (e: Exception) {
            Log.e(TAG, "Google Sign-In Error", e)
            Result.failure(e)
        }
    }

    override fun signInWithFacebook(): Result<String> {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG = "AuthRepository"
    }

}