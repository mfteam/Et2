package mfteam.com.et2.util;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by redugsi on 06/06/17.
 */

public abstract class SimpleTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}