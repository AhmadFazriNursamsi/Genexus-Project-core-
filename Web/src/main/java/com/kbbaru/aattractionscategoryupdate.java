package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.aattractionscategoryupdate", "/com.kbbaru.aattractionscategoryupdate"})
public final  class aattractionscategoryupdate extends GXWebObjectStub
{
   public aattractionscategoryupdate( )
   {
   }

   public aattractionscategoryupdate( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( aattractionscategoryupdate.class ));
   }

   public aattractionscategoryupdate( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aattractionscategoryupdate_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aattractionscategoryupdate_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Attractions Category Update";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

