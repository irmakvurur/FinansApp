// Generated by view binder compiler. Do not edit!
package com.example.finans.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finans.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGiderBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView accountTitle;

  @NonNull
  public final LinearLayout bankAccount1Layout;

  @NonNull
  public final LinearLayout bankAccount1Layout1;

  @NonNull
  public final LinearLayout bankAccount1Layout3;

  @NonNull
  public final TextView bankAccountInfo1;

  @NonNull
  public final TextView bankAccountInfo2;

  @NonNull
  public final TextView bankAccountInfo3;

  @NonNull
  public final ImageView bankImage1;

  @NonNull
  public final ImageView bankImage2;

  @NonNull
  public final ImageView bankImage3;

  @NonNull
  public final TextView bankName1;

  @NonNull
  public final TextView bankName2;

  @NonNull
  public final TextView bankName3;

  @NonNull
  public final TextView totalAmountText;

  @NonNull
  public final TextView welcomeText;

  private ActivityGiderBinding(@NonNull RelativeLayout rootView, @NonNull TextView accountTitle,
      @NonNull LinearLayout bankAccount1Layout, @NonNull LinearLayout bankAccount1Layout1,
      @NonNull LinearLayout bankAccount1Layout3, @NonNull TextView bankAccountInfo1,
      @NonNull TextView bankAccountInfo2, @NonNull TextView bankAccountInfo3,
      @NonNull ImageView bankImage1, @NonNull ImageView bankImage2, @NonNull ImageView bankImage3,
      @NonNull TextView bankName1, @NonNull TextView bankName2, @NonNull TextView bankName3,
      @NonNull TextView totalAmountText, @NonNull TextView welcomeText) {
    this.rootView = rootView;
    this.accountTitle = accountTitle;
    this.bankAccount1Layout = bankAccount1Layout;
    this.bankAccount1Layout1 = bankAccount1Layout1;
    this.bankAccount1Layout3 = bankAccount1Layout3;
    this.bankAccountInfo1 = bankAccountInfo1;
    this.bankAccountInfo2 = bankAccountInfo2;
    this.bankAccountInfo3 = bankAccountInfo3;
    this.bankImage1 = bankImage1;
    this.bankImage2 = bankImage2;
    this.bankImage3 = bankImage3;
    this.bankName1 = bankName1;
    this.bankName2 = bankName2;
    this.bankName3 = bankName3;
    this.totalAmountText = totalAmountText;
    this.welcomeText = welcomeText;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGiderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGiderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_gider, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGiderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accountTitle;
      TextView accountTitle = ViewBindings.findChildViewById(rootView, id);
      if (accountTitle == null) {
        break missingId;
      }

      id = R.id.bankAccount1Layout;
      LinearLayout bankAccount1Layout = ViewBindings.findChildViewById(rootView, id);
      if (bankAccount1Layout == null) {
        break missingId;
      }

      id = R.id.bankAccount1Layout1;
      LinearLayout bankAccount1Layout1 = ViewBindings.findChildViewById(rootView, id);
      if (bankAccount1Layout1 == null) {
        break missingId;
      }

      id = R.id.bankAccount1Layout3;
      LinearLayout bankAccount1Layout3 = ViewBindings.findChildViewById(rootView, id);
      if (bankAccount1Layout3 == null) {
        break missingId;
      }

      id = R.id.bankAccountInfo1;
      TextView bankAccountInfo1 = ViewBindings.findChildViewById(rootView, id);
      if (bankAccountInfo1 == null) {
        break missingId;
      }

      id = R.id.bankAccountInfo2;
      TextView bankAccountInfo2 = ViewBindings.findChildViewById(rootView, id);
      if (bankAccountInfo2 == null) {
        break missingId;
      }

      id = R.id.bankAccountInfo3;
      TextView bankAccountInfo3 = ViewBindings.findChildViewById(rootView, id);
      if (bankAccountInfo3 == null) {
        break missingId;
      }

      id = R.id.bankImage1;
      ImageView bankImage1 = ViewBindings.findChildViewById(rootView, id);
      if (bankImage1 == null) {
        break missingId;
      }

      id = R.id.bankImage2;
      ImageView bankImage2 = ViewBindings.findChildViewById(rootView, id);
      if (bankImage2 == null) {
        break missingId;
      }

      id = R.id.bankImage3;
      ImageView bankImage3 = ViewBindings.findChildViewById(rootView, id);
      if (bankImage3 == null) {
        break missingId;
      }

      id = R.id.bankName1;
      TextView bankName1 = ViewBindings.findChildViewById(rootView, id);
      if (bankName1 == null) {
        break missingId;
      }

      id = R.id.bankName2;
      TextView bankName2 = ViewBindings.findChildViewById(rootView, id);
      if (bankName2 == null) {
        break missingId;
      }

      id = R.id.bankName3;
      TextView bankName3 = ViewBindings.findChildViewById(rootView, id);
      if (bankName3 == null) {
        break missingId;
      }

      id = R.id.totalAmountText;
      TextView totalAmountText = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountText == null) {
        break missingId;
      }

      id = R.id.welcomeText;
      TextView welcomeText = ViewBindings.findChildViewById(rootView, id);
      if (welcomeText == null) {
        break missingId;
      }

      return new ActivityGiderBinding((RelativeLayout) rootView, accountTitle, bankAccount1Layout,
          bankAccount1Layout1, bankAccount1Layout3, bankAccountInfo1, bankAccountInfo2,
          bankAccountInfo3, bankImage1, bankImage2, bankImage3, bankName1, bankName2, bankName3,
          totalAmountText, welcomeText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
