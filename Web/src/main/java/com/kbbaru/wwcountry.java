package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.wwcountry", "/com.kbbaru.wwcountry"})
public final  class wwcountry extends GXWebObjectStub
{
   public wwcountry( )
   {
   }

   public wwcountry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwcountry.class ));
   }

   public wwcountry( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwcountry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwcountry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Countries";
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

