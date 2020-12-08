package com.jml.breaking.bad.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialFadeThrough
import com.jml.breaking.bad.R
import com.jml.breaking.bad.characters.domain.model.CharacterSeries
import com.jml.breaking.bad.characters.domain.vm.CharactersViewModel
import com.jml.breaking.bad.characters.domain.vm.state.CharactersState
import com.jml.breaking.bad.common.extensions.observeNonNull
import com.jml.breaking.bad.common.extensions.toast
import com.jml.breaking.bad.common.extensions.visibleGone
import com.jml.breaking.bad.common.ui.BaseFragment
import com.jml.breaking.bad.common.ui.widget.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {

    private val viewModel: CharactersViewModel by viewModel()
    private lateinit var charactersAdapter: CharactersAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeNonNull(viewModel.characters, ::showData)
        observeNonNull(viewModel.getLoadingLiveData(), ::showProgress)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough.create()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initList()
    }

    private fun initList() {
        charactersAdapter = CharactersAdapter()
            .apply {
                doOnItemClick = { _, _ -> }
            }
        character_recycler.apply {
            adapter = charactersAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun handleProductsState(state: CharactersState) {
        when (state) {
            is CharactersState.Data -> showData(state.data)
            is CharactersState.Error -> toast("Error!!!")
        }
    }

    private fun showData(data: List<CharacterSeries>) {
        charactersAdapter.setData(data)
    }

    private fun showProgress(show: Boolean) {
        character_progress.visibleGone(show)
    }
}