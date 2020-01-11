package kh.sergeimaleev.testtaskanoda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import kh.sergeimaleev.model.PhotoItem
import kh.sergeimaleev.testtaskanoda.R
import kh.sergeimaleev.testtaskanoda.databinding.ItemImagePageBinding

class ImageSlideAdapter(
    private val imagesUrlList: List<PhotoItem>
): PagerAdapter() {

    override fun isViewFromObject(view: View, viewObject: Any) = view == viewObject
    override fun getCount(): Int = imagesUrlList.size
    override fun destroyItem(container: ViewGroup, position: Int,  viewObject: Any) {
        container.removeView(viewObject as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding by lazy<ItemImagePageBinding> {
            DataBindingUtil.inflate(
                LayoutInflater.from(container.context), R.layout.item_image_page, container, false
            )
        }
        container.addView(binding.root)

        binding.url = imagesUrlList[position].url
        return binding.root
    }
}