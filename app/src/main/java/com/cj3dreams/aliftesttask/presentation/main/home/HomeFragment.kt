package com.cj3dreams.aliftesttask.presentation.main.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cj3dreams.aliftesttask.R
import com.cj3dreams.aliftesttask.di.BASE_URL
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: HomeViewModel by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getAll()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.homeRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.mutableLiveData.observe(viewLifecycleOwner, {
            recyclerView.adapter = HomeAdapter(requireContext(), it, this)
        })
    }

    override fun onClick(v: View?) {
        when(v!!.id) {

            R.id.itemRoot -> {
                val bundle = Bundle()
                bundle.putString("url", BASE_URL + v.tag as String)
                Navigation.findNavController(v)
                    .navigate(R.id.action_frgContainer_to_webViewFragment, bundle)
            }
        }
    }
}