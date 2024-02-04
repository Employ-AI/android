package com.client.datastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthDatastore @Inject constructor(private val app: Application) {
    companion object {
        private const val AUTH_KEY = "AUTH_KEY"
        private val UID_KEY = stringPreferencesKey("UID_KEY")
    }

    private val Context._datastore: DataStore<Preferences> by preferencesDataStore(name = AUTH_KEY)
    private val scope = CoroutineScope(Dispatchers.Main)

    suspend fun saveUid(uid: String) {
        app._datastore.edit { settings ->
            settings[UID_KEY] = uid
        }
    }

    suspend fun getUid(): String? {
        return app._datastore.data.map { settings ->
            settings[UID_KEY]
        }.first()
    }
}
