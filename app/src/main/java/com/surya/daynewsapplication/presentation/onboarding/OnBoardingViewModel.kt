package com.surya.daynewsapplication.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.surya.daynewsapplication.domain.usecases.app_entry.AppEntryUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}