package be.johnkichi.sampleapp.features.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import be.johnkichi.sampleapp.features.search.databinding.SearchFragmentBinding
import be.johnkichi.sampleapp.features.search.di.inject
import be.kichi.sampleapp.core.DFMSavedStateViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchFragment : BottomSheetDialogFragment() {

    private lateinit var binding: SearchFragmentBinding

    @Inject
    lateinit var savedStateViewModelFactory: DFMSavedStateViewModelFactory

    private val viewModel by viewModels<SearchViewModel> { savedStateViewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            binding.departureQuery
                .textChanges()
                .debounce(500)
                .collect { viewModel.searchFor(it) }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            binding.arrivalQuery
                .textChanges()
                .debounce(500)
                .collect { viewModel.searchFor(it) }
        }

        viewModel.searchResult.observe(viewLifecycleOwner) { options ->
            Log.d("FGV", "departure options: $options")
        }
    }
}
