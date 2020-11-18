package be.johnkichi.sampleapp.local.flowprefs

import android.content.Context
import androidx.preference.PreferenceManager
import be.johnkichi.sampleapp.local.PreferenceKeys
import com.tfcporciuncula.flow.FlowSharedPreferences
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class PreferencesHelper(private val context: Context) {
    //region backedEngine
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    private val flowPrefs = FlowSharedPreferences(prefs)
    //endregion

    //region app internals
    fun lastVersionCode() = flowPrefs.getInt(PreferenceKeys.lastVersionCode, 0)
    fun lastVersionCodeFlow(): Flow<Int> = lastVersionCode().asFlow()
    //endregion
}
