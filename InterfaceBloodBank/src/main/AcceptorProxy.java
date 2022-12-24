package main;

public class AcceptorProxy implements main.Acceptor {
  private String _endpoint = null;
  private main.Acceptor acceptor = null;
  
  public AcceptorProxy() {
    _initAcceptorProxy();
  }
  
  public AcceptorProxy(String endpoint) {
    _endpoint = endpoint;
    _initAcceptorProxy();
  }
  
  private void _initAcceptorProxy() {
    try {
      acceptor = (new main.AcceptorServiceLocator()).getAcceptor();
      if (acceptor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)acceptor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)acceptor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (acceptor != null)
      ((javax.xml.rpc.Stub)acceptor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.Acceptor getAcceptor() {
    if (acceptor == null)
      _initAcceptorProxy();
    return acceptor;
  }
  
  public java.lang.String acceptorRegistration(java.lang.String name, java.lang.String address, java.lang.String bloodType, java.lang.String phone, int quantity, java.lang.String medicalCondition) throws java.rmi.RemoteException{
    if (acceptor == null)
      _initAcceptorProxy();
    return acceptor.acceptorRegistration(name, address, bloodType, phone, quantity, medicalCondition);
  }
  
  
}