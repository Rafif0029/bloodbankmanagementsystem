package main;

public class ShiftManagementProxy implements main.ShiftManagement {
  private String _endpoint = null;
  private main.ShiftManagement shiftManagement = null;
  
  public ShiftManagementProxy() {
    _initShiftManagementProxy();
  }
  
  public ShiftManagementProxy(String endpoint) {
    _endpoint = endpoint;
    _initShiftManagementProxy();
  }
  
  private void _initShiftManagementProxy() {
    try {
      shiftManagement = (new main.ShiftManagementServiceLocator()).getShiftManagement();
      if (shiftManagement != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shiftManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shiftManagement)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shiftManagement != null)
      ((javax.xml.rpc.Stub)shiftManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.ShiftManagement getShiftManagement() {
    if (shiftManagement == null)
      _initShiftManagementProxy();
    return shiftManagement;
  }
  
  public java.lang.String doYouWanttoShiftEmployess(java.lang.String shift) throws java.rmi.RemoteException{
    if (shiftManagement == null)
      _initShiftManagementProxy();
    return shiftManagement.doYouWanttoShiftEmployess(shift);
  }
  
  
}