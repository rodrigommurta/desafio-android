package com.picpay.desafio.android.presentation.ui.utils.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.picpay.desafio.android.domain.utils.ErrorInformation
import org.junit.Rule
import org.junit.Test

class CacheAlertComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun cacheAlertComposableTest() {
        composeTestRule.setContent {
            CacheAlertComposable(
                error = ErrorInformation(
                    message = "Ocorreu um erro. Exibindo dados em cache."
                )
            )
        }

        composeTestRule.onNodeWithTag(TEXT_TAG).assertIsDisplayed()
    }
}