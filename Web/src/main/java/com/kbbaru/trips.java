package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.trips", "/com.kbbaru.trips"})
public final  class trips extends GXWebObjectStub
{
   public trips( )
   {
   }

   public trips( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( trips.class ));
   }

   public trips( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new trips_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new trips_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Trips";
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

