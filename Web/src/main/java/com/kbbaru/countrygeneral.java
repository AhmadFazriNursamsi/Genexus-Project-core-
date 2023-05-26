package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.countrygeneral", "/com.kbbaru.countrygeneral"})
public final  class countrygeneral extends GXWebObjectStub
{
   public countrygeneral( )
   {
   }

   public countrygeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( countrygeneral.class ));
   }

   public countrygeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new countrygeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new countrygeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Country General";
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

