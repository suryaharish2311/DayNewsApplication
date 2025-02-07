package com.surya.daynewsapplication.domain.usecases.app_entry

import com.surya.daynewsapplication.domain.manager.LocalUserManager


class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}