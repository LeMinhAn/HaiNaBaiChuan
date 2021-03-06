package io.xujiaji.hnbc.contract;

import android.support.annotation.StringRes;

import io.xujiaji.hnbc.contract.base.RefreshContract;
import io.xujiaji.hnbc.model.entity.Post;

/**
 * Created by jiana on 16-11-20.
 *
 */

public interface CollectContract {
    interface Presenter extends RefreshContract.Presenter {
        boolean isMe();

    }

    interface View extends RefreshContract.View<Post> {
        void showTitle(@StringRes int title);
    }
}
