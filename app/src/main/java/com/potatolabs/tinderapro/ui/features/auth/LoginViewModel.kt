package com.potatolabs.tinderapro.ui.features.auth

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.potatolabs.tinderapro.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginState(
    val isLoading : Boolean = false
)
sealed interface LoginEvents {
    data class OnLoginWithGoogle(
        val activity : Activity
    ) : LoginEvents
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.OnLoginWithGoogle -> signInWithGoogle(event.activity)
        }
    }

    private fun signInWithGoogle(activity: Activity) {
        viewModelScope.launch {

            _state.update {
                it.copy(isLoading = true)
            }

            authRepository
                .signInWithGoogle(activity)
                .onSuccess { uid ->

                    Log.d(TAG, "User signed in: $uid")
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }

                }
                .onFailure { exception ->
                    Log.e(TAG, "Google Sign-In failed", exception)
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}