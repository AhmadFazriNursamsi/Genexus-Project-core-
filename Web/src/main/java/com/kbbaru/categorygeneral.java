package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.categorygeneral", "/com.kbbaru.categorygeneral"})
public final  class categorygeneral extends GXWebObjectStub
{
   public categorygeneral( )
   {
   }

   public categorygeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categorygeneral.class ));
   }

   public categorygeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categorygeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categorygeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Category General";
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

