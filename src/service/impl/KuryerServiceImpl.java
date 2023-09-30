package service.impl;

import global.GlobalData;
import service.inter.KuryerService;

import java.time.LocalDateTime;

public class KuryerServiceImpl implements KuryerService {
    @Override
    public void checkKuryer() {
        for (int i = 0; i < GlobalData.orders.size(); i++) {
            if(GlobalData.orders.get(i).getDeliveryTime().isBefore(LocalDateTime.now())){
                GlobalData.orders.get(i).getKuryer().setEmpty(true);
            }
        }
    }
}
