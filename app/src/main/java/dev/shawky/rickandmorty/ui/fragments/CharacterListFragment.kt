package dev.shawky.rickandmorty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.shawky.rickandmorty.R
import dev.shawky.rickandmorty.databinding.FragmentCharacterListBinding
import dev.shawky.rickandmorty.ui.adapter.CharactersAdapter
import dev.shawky.rickandmorty.viewmodels.CharacterListViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentCharacterListBinding
    private val characterListViewModel: CharacterListViewModel by viewModel()
    private val charactersAdapter:CharactersAdapter = CharactersAdapter()
    private var searchJob: Job?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        search()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_character_list, container, false)
        initRecyclerView(binding.recyclerViewCharacterList)
        return binding.root
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            characterListViewModel.getCharacterListPaginated().collectLatest {
                charactersAdapter.submitData(it)
            }
        }
    }

    private fun initRecyclerView(recyclerViewCharacterList: RecyclerView) {
        recyclerViewCharacterList?.apply {
            layoutManager=LinearLayoutManager(context)
            adapter = charactersAdapter
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
        recyclerViewCharacterList.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager(context).orientation))

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharacterListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharacterListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}