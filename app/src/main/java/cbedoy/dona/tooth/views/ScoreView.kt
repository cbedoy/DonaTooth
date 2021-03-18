package cbedoy.dona.tooth.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import cbedoy.dona.tooth.R
import cbedoy.dona.tooth.databinding.CustomViewScoreBinding

class ScoreView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){

    val binding by lazy {
        CustomViewScoreBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        binding.root
    }

    var score: Int = 0
        set(value) {
            field = value
            updateStars(field)
        }

    private fun updateStars(value: Int) {
        for (x in 1 .. value) {
            with(binding){
                when(x) {
                    1-> scoreStar1.active()
                    2-> scoreStar2.active()
                    3-> scoreStar3.active()
                    4-> scoreStar4.active()
                    5-> scoreStar5.active()
                }
            }
        }

        for (x in value.plus(1) .. 5) {
            with(binding){
                when(x) {
                    1-> scoreStar1.empty()
                    2-> scoreStar2.empty()
                    3-> scoreStar3.empty()
                    4-> scoreStar4.empty()
                    5-> scoreStar5.empty()
                }
            }
        }
    }


    fun ImageView.active() {
        context?.let {
            setImageDrawable(ContextCompat.getDrawable(it, R.drawable.active_star))
        }
    }

    fun ImageView.empty() {
        context?.let {
            setImageDrawable(ContextCompat.getDrawable(it, R.drawable.empty_star))
        }
    }
}