@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app12_fragmentsexemplo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            Fragment01()
        else if (position == 1)
            Fragment02()
        else
            Fragment01()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Conversa"
        else if (position == 1)
            "Status"
        else
            "Anotações"
    }

}
