package edu.austral.lab1.odontobook.model;



/**
 * Date: 29/11/2005
 * Time: 22:57:14
 */
/**
 * This exception is used to mark (fatal) failures in infrastructure and system code.
 *
 * @author Christian Bauer <christian@hibernate.org>
 */
public class InfrastructureException
    extends RuntimeException
{

    //~ Constructors .........................................................................................

    public InfrastructureException() {}

    public InfrastructureException(String message)
    {
        super(message);
    }

    public InfrastructureException(Throwable cause)
    {
        super(cause);
    }

    public InfrastructureException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
