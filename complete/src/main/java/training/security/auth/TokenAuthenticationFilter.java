package training.security.auth;

import training.dto.User;
import training.security.TokenHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fan.jin on 2016-10-19.
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    private TokenHelper tokenHelper;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        logger.debug("Entering filter !");

        User user;
        String authToken = tokenHelper.getToken(request);
        logger.debug("authToken = "+authToken);

        if (authToken != null) {
            // get user from token
            user = tokenHelper.getUserFromToken(authToken);
            logger.debug("user = "+user);
            if (user != null) {
                logger.debug("Extracted user is "+user.getUsername());
                if (tokenHelper.validateToken(authToken, user)) {
                    // create authentication
                    logger.debug("Token is validated!");
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(user);
                    authentication.setToken(authToken);
                    logger.debug("Setting authentication with authorities = "+authentication.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

}