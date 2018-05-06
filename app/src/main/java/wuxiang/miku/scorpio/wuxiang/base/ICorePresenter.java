package wuxiang.miku.scorpio.wuxiang.base;

/**
 * Presenter接口用于解除订阅回调
 */

public interface ICorePresenter {
    void onViewStop();
    void onViewDestroy();

}
