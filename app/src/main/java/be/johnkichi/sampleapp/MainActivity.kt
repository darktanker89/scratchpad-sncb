package be.johnkichi.sampleapp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import be.johnkichi.sampleapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.doOnApplyWindowInsets

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }

    override fun onResume() {
        super.onResume()
//        GlobalScope.launch {
//            splashViewModel.railRrepository.disturbances().collect {
//                disturbances -> Log.d("FGV","$disturbances")
//            }
//        }
    }

    private fun setupUi() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.root.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        //region setup toolbar
        binding.mainToolbar.apply {
            setupWithNavController(
                navController,
                AppBarConfiguration(
                    topLevelDestinationIds = setOf(
                        R.id.search,
                        R.id.fatsearch,
                        R.id.announcements
//                        R.id.announcements,
//                        R.id.about
                    )
                )
            )
            inflateMenu(R.menu.menu_bottom_nav)
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search -> {
                        navController.navigate(R.id.search)
                        true
                    }
                    else -> menuItem.onNavDestinationSelected(navController)
                }
            }
            doOnApplyWindowInsets { view, insets, initialState ->
                view.updatePadding(
                    top = initialState.paddings.top + insets.systemWindowInsetTop,
                    left = initialState.paddings.left + insets.systemWindowInsetLeft,
                    right = initialState.paddings.right + insets.systemWindowInsetRight
                )
            }
        }
        //endregion
        //region bottomNavBar
        binding.mainBottomNav.apply {
            setupWithNavController(navController)
            doOnApplyWindowInsets { view, insets, initialState ->
                view.updatePadding(
                    bottom = initialState.paddings.bottom + insets.systemWindowInsetBottom,
                    left = initialState.paddings.left + insets.systemWindowInsetLeft,
                    right = initialState.paddings.right + insets.systemWindowInsetRight
                )
            }
        }
        //endregion
        //region navigation listener
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.announcementsDetail) {
                hideScaffolding()
            } else {
                showScaffolding()
            }
        }
        //endregion
    }

    private fun hideScaffolding() {
        binding.root.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE
        binding.motionLayout.apply {
            transitionToState(R.id.noScaffolding)
            getTransition(R.id.collapseScaffolding).setEnable(false)
        }
    }

    private fun showScaffolding() {
        binding.root.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        binding.motionLayout.apply {
            transitionToState(R.id.uncollapsedScaffolding)
            getTransition(R.id.collapseScaffolding).setEnable(true)
        }
    }
}
