@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app14_shortbiofragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            Sobre()
        else if (position == 1)
            Formacao()
        else if (position == 2)
            Experiencia()
        else
            Objetivo()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Sobre"
        else if (position == 1)
            "Formacao"
        else if (position == 2)
            "Experiencia"
        else
            "Objetivo"
    }

}