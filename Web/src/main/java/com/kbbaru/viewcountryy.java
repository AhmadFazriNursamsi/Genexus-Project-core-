package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.viewcountryy", "/com.kbbaru.viewcountryy"})
public final  class viewcountryy extends GXWebObjectStub
{
   public viewcountryy( )
   {
   }

   public viewcountryy( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( viewcountryy.class ));
   }

   public viewcountryy( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new viewcountryy_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new viewcountryy_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "View Countryy";
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

