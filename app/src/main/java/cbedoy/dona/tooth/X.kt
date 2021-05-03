package cbedoy.dona.tooth

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

interface ElementsProvider {
    fun loadElements(): Single<List<String>>
}

interface ListContract {
    interface View {
        fun setElements(elements: List<String>)
        fun showLoading()
        fun hideLoading()
        fun showError()
    }
}

class PresenterX (elementsProvider: ElementsProvider, view: ListContract.View){

    val disposables = CompositeDisposable()

    init {
        disposables.add(
            elementsProvider.loadElements()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .doOnSubscribe {
                    view.showLoading()
                }
                .doOnError {
                    view.showError()
                }
                .doOnSuccess {
                    view.hideLoading()
                }
                .subscribe { result, _ ->
                    view.setElements(result?: emptyList())
                }

        )
    }

}