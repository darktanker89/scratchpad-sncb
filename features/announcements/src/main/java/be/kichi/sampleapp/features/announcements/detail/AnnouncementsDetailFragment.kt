package be.kichi.sampleapp.features.announcements.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import be.kichi.sampleapp.core.DFMSavedStateViewModelFactory
import be.kichi.sampleapp.features.announcements.R
import be.kichi.sampleapp.features.announcements.databinding.AnnouncementsDetailFragmentBinding
import be.kichi.sampleapp.features.announcements.di.inject
import be.kichi.sampleapp.features.announcements.formatDate
import javax.inject.Inject

class AnnouncementsDetailFragment : Fragment() {

    private lateinit var binding: AnnouncementsDetailFragmentBinding
    val args: AnnouncementsDetailFragmentArgs by navArgs()

    @Inject
    lateinit var savedStateViewModelFactory: DFMSavedStateViewModelFactory

    private val viewModel by viewModels<AnnouncementsDetailViewModel> { savedStateViewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnnouncementsDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.helloText.text = args.disturbanceId
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    @SuppressLint("ResourceAsColor")
    override fun onResume() {
        super.onResume()
        viewModel.announcement.observe(
            viewLifecycleOwner,
            { disturbance ->
                Log.d("FGV", "go a new disturbance to show $disturbance")
                binding.title.text = disturbance.title
                binding.timestamp.text = formatDate(disturbance.timestamp.toLong() * 1_000)
                binding.description.text = disturbance.description
                binding.type.text = disturbance.type
                when (disturbance.type) {
                    "planned" -> {
                        binding.type.setTextColor(
                            ContextCompat.getColor(requireContext(), R.color.teal_200)
                        )
                    }
                    "disturbance" -> {
                        binding.type.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorError))
                    }
                    else -> binding.type.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                }
                disturbance.attachment?.let { attachment ->
                    binding.pdfButton.visibility = View.VISIBLE
                    binding.pdfButton.setOnClickListener {
                        Log.d("FGV", "pdf clicked")
                        openWeb(attachment)
                    }
                }
                binding.webButton.setOnClickListener {
                    Log.d("FGV", "web clicked")
                    openWeb(disturbance.link)
                }
            }
        )
        Log.d("FGV", "setting disturbance with id ${args.disturbanceId}")
        viewModel.setId(args.disturbanceId)
    }

    private fun openWeb(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}
