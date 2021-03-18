package cbedoy.dona.tooth.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import cbedoy.dona.tooth.databinding.CustomViewBottomMainBinding

class BottomActionMain @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){
    private val binding by lazy {
        CustomViewBottomMainBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        binding.root
    }
}