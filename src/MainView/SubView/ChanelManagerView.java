/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView.SubView;

import FormComponent.View.SSCChildView;
import FormComponent.SSCButtonChildTab;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 * @author PC
 */
public class ChanelManagerView extends SSCChildView {

    public ChanelManagerView(Scene scene) {
        super(scene);
    }

    @Override
    public String getBreadScrumbTitle() {
        return "Danh sách kênh";
    }

    @Override
    public String getBreadScrumbDescription() {
        return "Quản lý danh sách tài khoản youtube và kênh của bạn";
    }

    @Override
    public String getLeftMenuIcon() {
        return "USERS";
    }

    @Override
    public int getTabIndex() {
        return 0;
    }

    @Override
    public void initView(Scene scene) {
        

    }

    @Override
    public void reloadView() {
      
    }
    


    @Override
    public List<SSCButtonChildTab> getListMenuButton() {
        List<SSCButtonChildTab> arrButton = new ArrayList<>();
        arrButton.add(new SSCButtonChildTab("Lưu chạy", "CHECK_SQUARE_ALT", "Lưu danh sách đã chọn sẽ chạy", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             
            }
        }));
       
        return arrButton;

    }

}
