package cbedoy.dona.tooth.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import cbedoy.dona.tooth.databinding.CustomViewBottomViewBinding

class BottomNavigationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){

    private val binding by lazy {
        CustomViewBottomViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        binding.root
    }
}