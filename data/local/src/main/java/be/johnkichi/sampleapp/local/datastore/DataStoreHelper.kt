package be.johnkichi.sampleapp.local.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import be.johnkichi.sampleapp.local.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// datastore is not backed by sharedPref file, but we can migrate
// shared -> datastore - embedded
// datastore <- pref - require custom impl - out of scope
// 2 stores are of course uncorreleted, change in one won't affect the other
// TODO write a flipper plugin for datastore
class DataStoreHelper(private val context: Context) {

    // default sharedPrefs = "${context.packageName}_preferences"
    // migration clear the old sharedprefs, file exist but is empty
    val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "${context.packageName}_preferences",
        migrations = listOf(SharedPreferencesMigration(context, "${context.packageName}_preferences"))
    )

    fun lastVersionCode(): Flow<Int> = dataStore.data.map { preferences ->
        preferences[lastVersionKey] ?: 0
    }

    suspend fun setVersionCode(versionCode: Int) {
        dataStore.edit { settings ->
            settings[lastVersionKey] = versionCode
        }
    }

    companion object {
        private val lastVersionKey = preferencesKey<Int>(PreferenceKeys.lastVersionCode)
    }
}
