package com.example.tajakhabar.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

import com.example.tajakhabar.domain.manager.LocalUserManager
import com.example.tajakhabar.utils.Constant
import com.example.tajakhabar.utils.Constant.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImp(private val context: Context):LocalUserManager {
    override suspend fun saveAppEntry() {
       context.dataStore.edit {settings->
           settings[PreferenceKeys.APP_ENTRY] = true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
      return context.dataStore.data.map { settings->
          settings[PreferenceKeys.APP_ENTRY] ?: false
      }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

    private object PreferenceKeys{

        val APP_ENTRY = booleanPreferencesKey(name = Constant.APP_ENTRY )
    }
}

