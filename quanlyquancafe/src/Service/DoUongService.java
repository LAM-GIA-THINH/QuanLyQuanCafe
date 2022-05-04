/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Dao.DoUongDAo;
import Model.DoUong;
import java.util.List;
/**
 *
 * @author tuanta
 */
public class DoUongService {
    private DoUongDAo doUongDao;

    public DoUongService() {
        doUongDao = new DoUongDAo();
    }
    
    public List<DoUong> getaLL(){
       return doUongDao.getAll();
    }
    public void addDoUong(DoUong doUong){
        doUongDao.addDoUong(doUong);
    }
    public void deleteDoUong(int id){
        doUongDao.deleteDoUong(id);
    }
    
   public void updateDoUong(DoUong doUong){
        doUongDao.updateDoUong(doUong);
    }
   
   public DoUong getUserDoUong(int id){
        return doUongDao.getDoUongById(id);
    }

   
}
