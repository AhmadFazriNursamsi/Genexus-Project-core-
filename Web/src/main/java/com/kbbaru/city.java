package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.city", "/com.kbbaru.city"})
public final  class city extends GXWebObjectStub
{
   public city( )
   {
   }

   public city( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( city.class ));
   }

   public city( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new city_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new city_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "City";
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

