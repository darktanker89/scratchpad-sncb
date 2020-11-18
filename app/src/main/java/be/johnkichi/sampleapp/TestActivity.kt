package be.johnkichi.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import be.johnkichi.sampleapp.api.di.ApiModule
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.repository.LaunchesRepository
import be.johnkichi.sampleapp.repository.trains.IRailRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TestActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: LaunchesRepository

    @Inject
    lateinit var railRrepository: IRailRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    override fun onResume() {
        super.onResume()

/*        val db = DatabaseModule.providesDatabase(applicationContext)
        val dao = db.launchDao()

        val moshi = ApiModule.providesMoshi()
        val interceptor = ApiModule.providesHttpLoggingInterceptor()
        val okHttp = ApiModule.providesOkHttp(interceptor)
        val retrofit = ApiModule.providesRetrofit(okHttp, moshi, "https://api.spacexdata.com/")
        val spaceApi = retrofit.create(SpaceXService::class.java)

        val repository = LaunchesRepository(dao, spaceApi)*/

        // GlobalScope.launch {
        // repository.getAllLaunches().collect { launches ->
        //    Log.d("FGV", "x launches: $launches")
        //  }
        // }

        // Manual test injected
        GlobalScope.launch {
            railRrepository.disturbances().collect { disturbances ->
                Log.d("FGV", "disturbances $disturbances")
            }
        }

        // Manual test non injected
        GlobalScope.launch {
            val moshi = ApiModule.providesMoshi()
            val interceptor = ApiModule.providesHttpLoggingInterceptor()
            val okHttp = ApiModule.providesOkHttp(interceptor)
            val retrofit = ApiModule.providesRetrofit(okHttp, moshi, "https://api.irail.be")
            val iRailService = retrofit.create(IRailService::class.java)

            // val stations = iRailService.allStations()
            // Log.d("FGV", "x stations: $stations")

/*            val response = iRailService.feedbackOccupancy(
                OccupancyReport(
                    connection = "http://irail.be/connections/8871308/20160722/IC4516",
                    from = "http://irail.be/stations/NMBS/008871308",
                    date = "20160722",
                    vehicle = "http://irail.be/vehicle/IC4516",
                    occupancy = FieldOccupancy.LOW
                )
            )

            Log.d("FGV", "post report done $response")*/

            val response = iRailService.search("https://irail.be/stations/NMBS", "Je")
            Log.d("FGV", "post report done $response")
        }

/*        GlobalScope.launch {
            val response1 = api.getSuccess()
            when(response1) {
                is NetworkResponse.Success -> Log.d("FGV", "Success ${response1.body.name}")
                is NetworkResponse.ApiError -> Log.d("FGV", "ApiError ${response1.body.message}")
                is NetworkResponse.NetworkError -> Log.d("FGV", "NetworkError")
                is NetworkResponse.UnknownError -> Log.d("FGV", "UnknownError")
            }

            val response2 = api.getError()
            when (response2) {
                is NetworkResponse.Success -> Log.d("FGV", "Success ${response2.body.name}")
                is NetworkResponse.ApiError -> Log.d("FGV", "ApiError ${response2.body.message}")
                is NetworkResponse.NetworkError -> Log.d("FGV", "NetworkError")
                is NetworkResponse.UnknownError -> Log.d("FGV", "UnknownError")
            }
        }*/

//        val bottomSheetDialogFragment = SearchFragment.newInstance()
//        bottomSheetDialogFragment.show(supportFragmentManager, "tagbsdf")
    }
}
