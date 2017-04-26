package hwp.basketball.mobility.drillpreparation.step.selectplayers

import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.jakewharton.rxbinding2.InitialValueObservable
import com.jakewharton.rxbinding2.widget.RxTextView
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersContract
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 4/2/17.
 */
class PlayerDialog(val activity: DrillSetupActivity, val playersPresenter: PlayersContract.Presenter) {
    private lateinit var etFirst: EditText
    private lateinit var etLast: EditText
    private lateinit var spinPosition: Spinner
    private lateinit var etHeight: EditText
//    private lateinit var builder: AlertDialog.Builder

    init {
//        createBaseDialogBuilder()
    }

    fun createBaseDialogBuilder(): AlertDialog.Builder {
        val view = LayoutInflater.from(activity).inflate(R.layout.dlg_add_player, null)
        var builder = AlertDialog.Builder(activity)
                .setView(view)

        etFirst = view.findViewById(R.id.et_first_name) as EditText
        etLast = view.findViewById(R.id.et_last_name) as EditText
        spinPosition = view.findViewById(R.id.spinner_position) as Spinner
        etHeight = view.findViewById(R.id.et_height) as EditText

        val negativeText = activity.getString(android.R.string.cancel)
        builder.setNegativeButton(negativeText,
                { _, _ ->

                })
        return builder
    }

    fun showEditPlayerDialog(player: PlayerViewModel) {
        val builder = createBaseDialogBuilder()
        builder.setTitle(activity.getString(R.string.edit_new_player))
                .setMessage(activity.getString(R.string.edit_player_dialog_message))
                .setPositiveButton(android.R.string.ok,
                        { _, _ ->
                            playersPresenter.onEditPlayerButtonClicked(
                                    first = etFirst.text.toString(),
                                    last = etLast.text.toString(),
                                    position = spinPosition.selectedItem?.toString() ?: "Unknown",
                                    height = etHeight.text.toString())
                        })

        etFirst.setText(player.firstName)
        etLast.setText(player.lastName)
        etHeight.setText(player.height)

        val dialog = builder.create()
        dialog.show()

        addEditTextListeners(dialog, etFirst, etHeight, etLast)
    }

    fun showAddPlayerDialog() {
        val builder = createBaseDialogBuilder()
        builder.setTitle(activity.getString(R.string.add_new_player))
                .setMessage(activity.getString(R.string.add_player_dialog_message))
                .setPositiveButton(android.R.string.ok,
                        { _, _ ->
                            playersPresenter.onAddPlayerButtonClicked(
                                    first = etFirst.text.toString(),
                                    last = etLast.text.toString(),
                                    position = spinPosition.selectedItem?.toString() ?: "Unknown",
                                    height = etHeight.text.toString())
                        })

        val dialog = builder.create()
        dialog.show()
        addEditTextListeners(dialog, etFirst, etHeight, etLast)
    }

    private fun addEditTextListeners(dialog: AlertDialog, first: EditText, height: EditText, last: EditText) {
        val firstObservable: InitialValueObservable<CharSequence> = RxTextView.textChanges(first)
        val lastObservable: InitialValueObservable<CharSequence> = RxTextView.textChanges(last)
        val heightObservable: InitialValueObservable<CharSequence> = RxTextView.textChanges(height)
        val btnOk = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        setupPositionSpinner()

        btnOk.isEnabled = false

        val disposable = Observable.combineLatest(firstObservable, lastObservable, heightObservable,
                Function3 { first: CharSequence, last: CharSequence, height: CharSequence ->
                    first.isNotBlank() && last.isNotBlank() && height.isNotBlank()
                })
                .subscribe { btnOk.isEnabled = it }

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(disposable)

        dialog.setOnDismissListener {
            compositeDisposable.clear()
            Timber.d("disposing dialog observables")
        }
    }

    private fun setupPositionSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(activity,
                R.array.playing_positions, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinPosition.adapter = adapter
        spinPosition.prompt = activity.getString(R.string.country_prompt)
    }


}