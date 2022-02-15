package com.lucascabral.moviesapp.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucascabral.moviesapp.databinding.FragmentMainBinding
import com.lucascabral.moviesapp.presenter.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            binding.rvMovies.setHasFixedSize(true)
            binding.rvMovies.adapter = MoviesAdapter(movies)
        }

        viewModel.getMovies()
    }
}