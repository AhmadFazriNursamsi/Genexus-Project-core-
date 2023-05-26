package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.viewenterattraction", "/com.kbbaru.viewenterattraction"})
public final  class viewenterattraction extends GXWebObjectStub
{
   public viewenterattraction( )
   {
   }

   public viewenterattraction( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( viewenterattraction.class ));
   }

   public viewenterattraction( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new viewenterattraction_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new viewenterattraction_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "View Enter Attraction";
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

