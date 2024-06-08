package com.example.tajakhabar.domain.manager.useCase

import com.example.tajakhabar.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}