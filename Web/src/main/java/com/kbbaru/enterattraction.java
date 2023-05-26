package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.enterattraction", "/com.kbbaru.enterattraction"})
public final  class enterattraction extends GXWebObjectStub
{
   public enterattraction( )
   {
   }

   public enterattraction( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( enterattraction.class ));
   }

   public enterattraction( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new enterattraction_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new enterattraction_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Enter Attraction";
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

