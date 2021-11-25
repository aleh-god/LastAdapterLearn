package by.godevelopment.lastadapterlearn.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.godevelopment.lastadapterlearn.BR
import by.godevelopment.lastadapterlearn.R
import by.godevelopment.lastadapterlearn.databinding.MainFragmentBinding
import com.github.nitrico.lastadapter.LastAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        LastAdapter(viewModel.data, BR.viewModel)
            .map<ItemViewModel>(R.layout.item)
            .map<HeaderViewModel>(R.layout.item_header)
            .into(binding.recyclerView)

        return binding.root
    }
}
