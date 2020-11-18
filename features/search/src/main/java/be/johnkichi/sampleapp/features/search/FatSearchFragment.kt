package be.johnkichi.sampleapp.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import be.johnkichi.sampleapp.features.search.databinding.FatSearchFragmentBinding

class FatSearchFragment : Fragment() {

    private lateinit var binding: FatSearchFragmentBinding

    private lateinit var viewModel: FatSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FatSearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FatSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
