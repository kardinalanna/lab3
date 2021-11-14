package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Second : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_a2_to_a3)?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_Second_to_Third)
        }

        view?.findViewById<Button>(R.id.btn_a2_to_a1)?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_Second_to_First)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == R.id.about ) {
            (activity as MainActivity).navController.navigate(R.id.action_Second_to_activityAbout)
            true
        }
        else return super.onOptionsItemSelected(item)
    }

}