package main;

public class DonorProxy implements main.Donor {
  private String _endpoint = null;
  private main.Donor donor = null;
  
  public DonorProxy() {
    _initDonorProxy();
  }
  
  public DonorProxy(String endpoint) {
    _endpoint = endpoint;
    _initDonorProxy();
  }
  
  private void _initDonorProxy() {
    try {
      donor = (new main.DonorServiceLocator()).getDonor();
      if (donor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)donor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)donor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (donor != null)
      ((javax.xml.rpc.Stub)donor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.Donor getDonor() {
    if (donor == null)
      _initDonorProxy();
    return donor;
  }
  
  public java.lang.String donorRegistration(java.lang.String name, java.lang.String address, java.lang.String bloodType, java.lang.String phone, int quantity, java.lang.String medicalCondition) throws java.rmi.RemoteException{
    if (donor == null)
      _initDonorProxy();
    return donor.donorRegistration(name, address, bloodType, phone, quantity, medicalCondition);
  }
  
  
}