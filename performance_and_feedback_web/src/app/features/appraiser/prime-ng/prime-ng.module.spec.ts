import { PrimeNgModule } from './prime-ng.module';

describe('PrimeNgModule', () => {
  let primeNgModule: PrimeNgModule;

  beforeEach(() => {
    primeNgModule = new PrimeNgModule();
  });

  it('should create an instance', () => {
    expect(primeNgModule).toBeTruthy();
  });
});
