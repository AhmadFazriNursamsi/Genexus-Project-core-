package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.category", "/com.kbbaru.category"})
public final  class category extends GXWebObjectStub
{
   public category( )
   {
   }

   public category( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( category.class ));
   }

   public category( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new category_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new category_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Category";
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

