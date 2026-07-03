package com.potatolabs.tinderapro.ui.features.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.potatolabs.tinderapro.R
import com.potatolabs.tinderapro.common.ui.TextLogo
import com.potatolabs.tinderapro.ui.theme.TinderaProTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier
    ) { padding ->

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.login_bg),
                contentDescription = stringResource(R.string.login_background),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = stringResource(R.string.logo),
                    modifier = Modifier.size(120.dp)
                )

                Spacer(Modifier.height(12.dp))

                TextLogo()

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Smart POS for every Sari-Sari Store",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(Modifier.height(12.dp))

                HorizontalDivider(
                    modifier = Modifier.width(100.dp),
                    thickness = 3.dp,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(Modifier.height(40.dp))

                Text(
                    text = "Welcome back!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = "Sign in to access your store",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(Modifier.height(24.dp))

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    onClick = onGoogleClick,
                    shape = MaterialTheme.shapes.medium,
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {

                    Image(
                        painter = painterResource(R.drawable.ic_google),
                        contentDescription = null
                    )

                    Spacer(Modifier.width(12.dp))

                    Text("Continue with Google")
                }

                Spacer(Modifier.height(12.dp))

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    onClick = onFacebookClick,
                    shape = MaterialTheme.shapes.medium,
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {

                    Image(
                        painter = painterResource(R.drawable.ic_facebook),
                        contentDescription = null
                    )

                    Spacer(Modifier.width(12.dp))

                    Text("Continue with Facebook")
                }

                Spacer(Modifier.height(24.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        "  OR  ",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    )
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Security,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )

                        Spacer(Modifier.width(16.dp))

                        Column {
                            Text(
                                "Secure & Passwordless",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                "Sign in securely with Google or Facebook.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    text = stringResource(R.string.terms),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun LoginScreenPrev() {
    TinderaProTheme() {
        LoginScreen()
    }
}