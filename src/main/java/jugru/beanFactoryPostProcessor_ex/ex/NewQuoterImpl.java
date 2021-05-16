package jugru.beanFactoryPostProcessor_ex.ex;


public class NewQuoterImpl extends QuoterImpl{
    @Override
    public void sayQuoter() {
        System.out.print("New Impl : ");
        super.sayQuoter();
    }
}
