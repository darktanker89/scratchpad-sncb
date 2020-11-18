package be.kichi.sampleapp.features.announcements.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.johnkichi.sampleapp.models.Disturbance
import be.kichi.sampleapp.core.DFMSavedStateViewModelFactory
import be.kichi.sampleapp.features.announcements.databinding.AnnouncementsFragmentBinding
import be.kichi.sampleapp.features.announcements.di.inject
import be.kichi.sampleapp.features.announcements.ui.DisturbanceAdapter
import javax.inject.Inject

class AnnouncementsFragment : Fragment(), AnnouncementSelectionListener {

    private lateinit var binding: AnnouncementsFragmentBinding

    @Inject
    lateinit var savedStateViewModelFactory: DFMSavedStateViewModelFactory

    private val viewModel by viewModels<AnnouncementsViewModel> { savedStateViewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnnouncementsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(binding.rvDisturbances) {
            adapter = DisturbanceAdapter(this@AnnouncementsFragment)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.announcements.observe(
            this,
            {
                disturbances ->
                Log.d("FGV", "disturbances received $disturbances")
                (binding.rvDisturbances.adapter as DisturbanceAdapter).setData(disturbances)
            }
        )
    }

    override fun onAnnouncementClicked(disturbance: Disturbance) {
        Log.d("FGV", "annoucement clicked: $disturbance")
        findNavController().navigate(AnnouncementsFragmentDirections.goToAnnouncementsDetailFragment(disturbanceId = disturbance.id))
    }
}
